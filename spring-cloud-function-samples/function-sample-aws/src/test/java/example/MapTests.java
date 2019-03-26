/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package example;

import org.junit.Ignore;
import org.junit.Test;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 *
 */
@Ignore
public class MapTests {

	@Test
	public void test() {
		Bar result = new Config(new Properties()).function().apply(new Foo("foo"));
		assertThat(result.getValue()).isEqualTo("FOO");
	}

	@Test
	public void start() throws Exception {
		SpringBootRequestHandler<Object, Object> handler = new SpringBootRequestHandler<>(Config.class);
		handler.handleRequest(new Foo("foo"), null);
		handler.close();
	}

}
