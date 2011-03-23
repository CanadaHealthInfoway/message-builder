package ca.infoway.messagebuilder.terminology.loader.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ca.infoway.messagebuilder.maven.util.OutputUIImpl;

/**
 * <p>This goal reads in a terminology file and writes terminology entries to the 
 * database.
 *
 * @goal terminology-load
 */
public class TerminologyLoaderMojo extends AbstractMojo {
	
    /**
     * <p>The terminology spreadsheet that contains entries that we want to read from.
     * 
     * @parameter
     * @required
     */
    private File spreadsheet;
    
    /**
     * <p>The URL to the database that contains the terminology tables.
     * 
     * @parameter
     * @required
     */
    private String terminologyDatabaseUrl;
    
    /**
     * @parameter
     * @required
     */
    private String terminologyDatabaseUsername;
    
    /**
     * @parameter
     * @required
     */
    private String terminologyDatabasePassword;
    
    /**
     * @parameter
     * @required
     */
    private String terminologyDatabaseDriver;
    
    /**
     * @parameter
     */
    private String terminologyDatabaseDialect;
    
    /**
     * <p>Read in the spreadsheet, and try to load each entry into the database.
     * 
     * @throws MojoExecutionException 
     *    - if an error was encountered trying to load the entries.
     */
	public void execute() throws MojoExecutionException {
		if (this.spreadsheet == null || !this.spreadsheet.exists() || !this.spreadsheet.isFile()) {
			throw new MojoExecutionException("Please specify a valid terminology spreadsheet");
		} else {
			generate();
		}
	}

	private void generate() throws MojoExecutionException {
		try {
			HSSFWorkbook workbook = createWorkBook();
			HibernateDatabase database = new HibernateDatabase(createProperties());
			database.startTransaction();
			new TerminologyProcessor(new OutputUIImpl(this), workbook, database).process();
			database.commitTransaction();
		} catch (IOException e) {
			throw new MojoExecutionException("Problem reading spreadsheet: " 
					+ this.spreadsheet.getAbsolutePath(), e);
		} catch (TerminologyLoaderException e) {
			throw new MojoExecutionException("Problem processing spreadsheet: " + e.getMessage(), e);
		}
	}

	private Properties createProperties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:temp");
		properties.setProperty("hibernate.connection.url", this.terminologyDatabaseUrl);
//		properties.setProperty("hibernate.connection.username", "sa");
		properties.setProperty("hibernate.connection.username", this.terminologyDatabaseUsername);
		properties.setProperty("hibernate.connection.password", this.terminologyDatabasePassword);
//		properties.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
		properties.setProperty("hibernate.connection.driver_class", this.terminologyDatabaseDriver);
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.setProperty("hibernate.dialect", this.terminologyDatabaseDialect);
		if (getLog().isDebugEnabled()) {
			properties.setProperty("hibernate.show_sql", "true");
		} else {
			properties.setProperty("hibernate.show_sql", "false");
		}
		properties.setProperty("hibernate.cache.use_second_level_cache", "false");
		return properties;
	}

	private HSSFWorkbook createWorkBook() throws IOException {
		InputStream input = new FileInputStream(this.spreadsheet);
		try {
			return new HSSFWorkbook(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
