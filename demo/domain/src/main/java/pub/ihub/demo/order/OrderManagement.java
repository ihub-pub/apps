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

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.ddd.annotation.Service;
import org.jmolecules.event.annotation.DomainEventPublisher;
import org.springframework.context.ApplicationContext;
import pub.ihub.demo.customer.Address;
import pub.ihub.demo.customer.Customer;
import pub.ihub.demo.customer.Customers;
import pub.ihub.demo.customer.SampleEvent;

import static org.jmolecules.event.annotation.DomainEventPublisher.PublisherType.INTERNAL;

/**
 * @author henry
 */
@AllArgsConstructor
@Service
@Slf4j
public class OrderManagement {

	private Customers customers;
	private Orders orders;
	private ApplicationContext applicationContext;

	public Customer save() {
		var address = new Address("41 Greystreet", "Dreaming Tree", "2731");

		var customer = customers.save(new Customer("Dave", "Matthews", address));

		var order = orders.save(new Order(customer));

		publish("消息一");
		publish("消息二");
		publish("消息三");
		publish("消息四");
		publish("消息五");
		publish("消息六");
		publish("消息七");

		return customers.resolveRequired(order.getCustomer());
	}

	@DomainEventPublisher(publishes = "demo.sample", type = INTERNAL)
	void publish(String msg) {
		log.info("发布消息：{}", msg);
		applicationContext.publishEvent(new SampleEvent(msg));
	}

}
