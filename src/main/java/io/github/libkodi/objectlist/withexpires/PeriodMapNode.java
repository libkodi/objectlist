package io.github.libkodi.objectlist.withexpires;

/**
 * 数据节点
 *
 * @param <T> 数据节点保存的数据类型
 */
public class PeriodMapNode<T> {
	private T value = null;
	private long createtime;
	private long activetime;
	private int idleTimeout = 120;
	private int aliveTimeout = 7200;
	
	public PeriodMapNode(T value) {
		this.value = value;
		createtime = System.currentTimeMillis();
		activetime = createtime;
	}
	
	public PeriodMapNode(T value, int maxIdle, int maxAlive) {
		this.value = value;
		idleTimeout = maxIdle;
		aliveTimeout = maxAlive;
		createtime = System.currentTimeMillis();
		activetime = createtime;
	}
	
	public T getValue() {
		return value;
	}
	
	public PeriodMapNode<T> setIdleTimeout(int idleTimeout) {
		this.idleTimeout = idleTimeout;
		return this;
	}
	
	public int getIdleTimeout() {
		return idleTimeout;
	}
	
	public int getAliveTimeout() {
		return aliveTimeout;
	}
	
	public PeriodMapNode<T> setAliveTimeout(int aliveTimeout) {
		this.aliveTimeout = aliveTimeout;
		return this;
	}
	
	public void renew() {
		activetime = System.currentTimeMillis();
	}
	
	public boolean isIdleTimeout() {
		return idleTimeout < 1 ? false : ((System.currentTimeMillis() - activetime) / 1000) >= idleTimeout;
	}
	
	public boolean isAliveTimeout() {
		return aliveTimeout < 1 ? false : ((System.currentTimeMillis() - createtime) / 1000) >= aliveTimeout;
	}
}
