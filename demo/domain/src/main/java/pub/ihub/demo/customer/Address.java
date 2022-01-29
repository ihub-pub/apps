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

import lombok.Getter;
import lombok.Value;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

/**
 * 地址
 *
 * @author henry
 */
@Getter
public class Address implements Entity<Customer, Address.AddressId> {

	/**
	 * 地址ID
	 */
	private Address.AddressId id;
	/**
	 * 街道
	 */
	private final String street;
	/**
	 * 城市
	 */
	private final String city;
	/**
	 * 邮编
	 */
	private final String zipCode;

	public Address(String street, String city, String zipCode) {

		this.id = AddressId.of(UUID.randomUUID());
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	/**
	 * 地址ID
	 */
	@Value(staticConstructor = "of")
	public static class AddressId implements Identifier {

		/**
		 * ID
		 */
		private final UUID id;
	}

}
