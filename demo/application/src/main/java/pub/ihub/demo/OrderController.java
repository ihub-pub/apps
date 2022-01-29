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
package pub.ihub.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pub.ihub.demo.customer.Customer;
import pub.ihub.demo.order.OrderManagement;

/**
 * 订单
 * <p>
 * 描述
 * 123
 * 456
 * 789
 *
 * @author henry
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "order")
public class OrderController {

	/**
	 * 属性
	 */
	private OrderManagement orderManagement;

	/**
	 * 保存用户
	 * <p>
	 * 描述
	 *
	 * @return 结果
	 * @throws Exception
	 */
	@PostMapping("save")
	public Customer save() throws Exception {
		return orderManagement.save();
	}

	/**
	 * 获取用户
	 *
	 * @param a 参数a
	 * @param b 参数b
	 * @return 用户
	 */
	@GetMapping
	public Customer get(String a, @RequestParam(required = false) String b) {
		return orderManagement.save();
	}

	/**
	 * 没有注解
	 */
	public void hehe() {

	}

}
