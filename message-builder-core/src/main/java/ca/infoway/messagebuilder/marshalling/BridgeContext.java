/**
 * 
 */
package ca.infoway.messagebuilder.marshalling;

class BridgeContext {
	
	private final boolean collapsed;
	private final Integer index;

	BridgeContext() {
		this(false);
	}
	BridgeContext(boolean collapsed) {
		this.collapsed = collapsed;
		this.index = null;
	}
	BridgeContext(boolean collapsed, Integer index) {
		this.collapsed = collapsed;
		this.index = index;
	}
	public boolean isCollapsed() {
		return this.collapsed;
	}
	public Integer getOriginalIndex() {
		return this.index;
	}
	public int getIndex() {
		if (this.index == null) {
			throw new IllegalStateException("index is null");
		} else {
			return this.index.intValue();
		}
	}
	public boolean isIndexed() {
		return this.index != null;
	}
}