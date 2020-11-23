package com.ugps.curso.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ugps.curso.entities.Order;
import com.ugps.curso.entities.Product;

@Embeddable //pois é uma classe auxiliar de chave primária composta (ver diagrama da UML)
public class OrderItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	//essa é uma classe auxiliar. Não vou colocar construtor.
	
	@ManyToOne
	@JoinColumn(name = "order_id") //essa é a chave estrangeira no BD relacional.
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id") //essa é a chave estrangeira no BD relacional.
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
	
	
	
	
}
