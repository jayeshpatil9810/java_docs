package com.v2.shopnest.payment_module.model;

public class PaypalWebhookEvent {

	private String id;
	private String event_type;
	private String create_time;

	public PaypalWebhookEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaypalWebhookEvent(String id, String event_type, String create_time) {
		super();
		this.id = id;
		this.event_type = event_type;
		this.create_time = create_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "PaypalWebhookEvent [id=" + id + ", event_type=" + event_type + ", create_time=" + create_time + "]";
	}

	
}
