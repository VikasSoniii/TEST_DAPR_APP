package org.sds.samsung.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderEvent {
    private Data data;
    private String datacontenttype;
    private String expiration;
    private String id;
    private String pubsubname;
    private String source;
    private String specversion;
    private String time;
    private String topic;
    private String traceid;
    private String traceparent;
    private String tracestate;
    private String type;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getDatacontenttype() {
        return datacontenttype;
    }

    public void setDatacontenttype(String datacontenttype) {
        this.datacontenttype = datacontenttype;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPubsubname() {
        return pubsubname;
    }

    public void setPubsubname(String pubsubname) {
        this.pubsubname = pubsubname;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSpecversion() {
        return specversion;
    }

    public void setSpecversion(String specversion) {
        this.specversion = specversion;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTraceid() {
        return traceid;
    }

    public void setTraceid(String traceid) {
        this.traceid = traceid;
    }

    public String getTraceparent() {
        return traceparent;
    }

    public void setTraceparent(String traceparent) {
        this.traceparent = traceparent;
    }

    public String getTracestate() {
        return tracestate;
    }

    public void setTracestate(String tracestate) {
        this.tracestate = tracestate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

        public static class Data {
            private String id;
            private double amount;
            private String orderId;

            // Jackson annotation to map JSON fields to Java properties
            @JsonProperty("amount")
            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            @JsonProperty("orderId")
            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            @JsonProperty("id")
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }


