package com.example.notification.utils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.notification.service.Channel;

@Service
public class ChannelFactory {
    private static final String CHANNEL_NAME_SUFFIX = "Channel";
    private final BeanFactory beanFactory;

	
	@Autowired
	@Qualifier("emailChannel")
	private Channel emailChannel;
	
	@Autowired
	@Qualifier("smsChannel")
	private Channel smsChannel;
	
    @Autowired
    public ChannelFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Channel getChannel(String channel) {
        return beanFactory.getBean(channel + CHANNEL_NAME_SUFFIX, 
          Channel.class);
    }

}
