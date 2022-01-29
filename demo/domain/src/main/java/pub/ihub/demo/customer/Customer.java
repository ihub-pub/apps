/*
 * Copyright (c) 2021 Henry 李恒 (henry.box@outlook.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pub.ihub.demo.customer;

import cn.hutool.core.lang.Assert;
import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 用户
 *
 * @author henry
 */
@Getter
public class Customer implements AggregateRoot<Customer, CustomerId> {

	/**
	 * 用户ID
	 */
	private final CustomerId id;
	/**
	 * 名
	 */
	private String firstname;
	/**
	 * 姓
	 */
	private String lastname;
	/**
	 * 地址
	 */
	private List<Address> addresses;

	public Customer(String firstname, String lastname, Address address) {

		Assert.notNull(address, "Address must not be null!");

		this.id = CustomerId.of(UUID.randomUUID().toString());

		this.firstname = firstname;
		this.lastname = lastname;

		this.addresses = new ArrayList<>();
		this.addresses.add(address);
	}

}
