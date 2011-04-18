package ca.infoway.messagebuilder.model.broadcast;

import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.broadcast.BroadcastMessageBean;


public class BroadcastMessageBeanBuilder extends BaseBeanBuilder<BroadcastMessageBean> {
	
	public BroadcastMessageBeanBuilder() {
		super(new BroadcastMessageBean());
	}

	public BroadcastMessageBeanBuilder populate() {
		this.bean.setBroadcastSource("some broadcast source");
		this.bean.setBroadcastTopic(new BroadcastTopicBeanBuilder().populateAsNlMandatory().create());
		this.bean.setEffectiveTime(DateUtil.getDate(2015, 4, 22));
		this.bean.setText("Tires are being marked. Move your cars");
		this.bean.setTitle("Parking warning");
		return this;
	}

}
