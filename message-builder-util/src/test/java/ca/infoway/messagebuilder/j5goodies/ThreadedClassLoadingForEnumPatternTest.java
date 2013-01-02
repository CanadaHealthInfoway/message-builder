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
 * Last modified: $LastChangedDate: 2011-04-27 13:53:25 -0400 (Wed, 27 Apr 2011) $
 * Revision:      $LastChangedRevision: 2575 $
 */

package ca.infoway.messagebuilder.j5goodies;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.lang.EnumPattern;

public class ThreadedClassLoadingForEnumPatternTest {

	private Exception exception;

	/**
	 * Create 20 threads that will each try call EnumPattern.values
	 * Depending if the MyEnum values are fully initialized or not,
	 * we may not be able to find an enum value on a given thread.
	 * If that is the case we throw an exception. This is fixed by
	 * forcing the loading of the enum class in EnumPattern.values.
	 */
	@Test
	public void runThreadTest() throws Exception {
		System.out.println("starting test");
		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0; i < 20; ++i) {
			Thread thread = new Thread(new Worker(i), "" + i);
			threads.add(thread);
		}
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		if (this.exception != null) {
			throw this.exception;
		}
	}

	class Worker implements Runnable {
		private final int id;
		public Worker(int i) {
			this.id = i;
		}
		public void run() {
			System.out.println("Thread " + id + " is starting");
			try {
				Thread.sleep(id);
				boolean found = false;
				for (MyEnum myEnum : EnumPattern.<MyEnum>values(MyEnum.class)) {
					if (myEnum.name().equals("five")) {
						found = true;
						break;
					}
				}
				if (!found) {
					throw new IllegalStateException("five not found in MyEnum");
				}
				System.out.println("Thread " + id + " is done");
			} catch (Exception e) {
				e.printStackTrace();
				ThreadedClassLoadingForEnumPatternTest.this.exception = e;
			}
		}
	}
}

class MyEnum extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	private static final long serialVersionUID = 5652658904524564487L;
	public static final MyEnum ONE = new MyEnum("one");
	public static final MyEnum TWO = new MyEnum("two");
	public static final MyEnum THREE = new MyEnum("three");
	public static final MyEnum FOUR = new MyEnum("four");
	public static final MyEnum FIVE = new MyEnum("five");
	private MyEnum(String string) {
		super(string);
		System.out.println("adding: " + string);
	}
}