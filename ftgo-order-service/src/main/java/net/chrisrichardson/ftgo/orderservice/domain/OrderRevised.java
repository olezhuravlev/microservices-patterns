package net.chrisrichardson.ftgo.orderservice.domain;

import net.chrisrichardson.ftgo.common.Money;
import net.chrisrichardson.ftgo.orderservice.api.events.OrderDomainEvent;

public class OrderRevised implements OrderDomainEvent {
	private final OrderRevision orderRevision;
	private final Money         currentOrderTotal;
	private final Money         newOrderTotal;

	public OrderRevised(OrderRevision orderRevision, Money currentOrderTotal, Money newOrderTotal) {
		this.orderRevision     = orderRevision;
		this.currentOrderTotal = currentOrderTotal;
		this.newOrderTotal     = newOrderTotal;
	}
	
	public OrderRevision getOrderRevision()     { return orderRevision;     }
	public Money         getCurrentOrderTotal() { return currentOrderTotal; }
	public Money         getNewOrderTotal()     { return newOrderTotal;     }
}
