/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 18:05:34 -0400 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.resolver;

import ca.infoway.messagebuilder.Code;

/**
 * @author Tom
 *
 * @sharpen.ignore - terminology - translated manually
 */
public interface GenericCodeResolverRegistry extends CodeResolver {

    /**
     * <p>Gets the resolver.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the resolver
     */
	public <T extends Code> CodeResolver getResolver(Class<T> type);

    public boolean isInitialized();
    
    /**
     * <p>Register.
     *
     * @param codeResolver the code resolver
     */
    public void register(CodeResolver codeResolver);
    
    /**
     * <p>Register resolver.
     *
     * @param type the type
     * @param codeResolver the code resolver
     */
    public void registerResolver(Class<? extends Code> type, CodeResolver codeResolver);
    
    public void unregisterAll();
    
}
