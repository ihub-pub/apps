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
package pub.ihub.demo.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import pub.ihub.demo.customer.Customer;
import pub.ihub.demo.customer.CustomerId;

import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * @author henry
 */
@Table(name = "SAMPLE_ORDER")
@Getter
@RequiredArgsConstructor
public class Order implements AggregateRoot<Order, OrderId> {

	private final OrderId id;
	private List<LineItem> lineItems;
	private Association<Customer, CustomerId> customer;

	public Order(Customer customer) {

		this.id = OrderId.of(UUID.randomUUID());
		this.customer = Association.forAggregate(customer);
	}

}
