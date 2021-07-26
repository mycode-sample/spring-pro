package com.sheepfly.springpro.part1;

public class MessageRendererImpl implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() throws Exception {
        if (this.messageProvider == null) {
            throw new Exception("must set messageProvider.");
        }
        System.out.println(this.messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
