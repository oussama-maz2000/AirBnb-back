package com.seloger.propertyPart.patterns.chain;

import java.util.List;

public final class ChainBuilder<T> {
    private ChainBuilder() {
    }
    public static <T>ChainBuilder<T> chainBuilder() {
        return new ChainBuilder<>();
    }

    // First Handler of chain
    private HandlerImpl<T> first;

    public SuccessorBuilder first(final Handler<T> handler) {
        first = new HandlerImpl<>(handler);
        return new SuccessorBuilder(first);
    }


    @SuppressWarnings("PublicInnerClass")
    public final class SuccessorBuilder {

        private HandlerImpl<T> current;

        private SuccessorBuilder(final HandlerImpl<T> current) {
            this.current = current;
        }

        public SuccessorBuilder next(final Handler<T> next) {
            final HandlerImpl<T> successorWrapper = new HandlerImpl<>(next);
            current.setNext(successorWrapper);
            current = successorWrapper;
            return this;
        }

        public IChain<T> build() {
            return new ChainImpl<>(first);
        }
    }


    private static final class ChainImpl<T> implements IChain<T> {

        private final Handler<T> first;

        private ChainImpl(final Handler<T> first) {
            this.first = first;
        }

        @Override
        public void handle(final T t) {
            first.handle(t);
        }

        @Override
        public void handleTwo(T t) {

                first.handleTwo(t);

        }
    }

    private static final class HandlerImpl<T> implements Handler<T> {

        private final Handler<T> delegate;
        private       Handler<T> next;


        private HandlerImpl(final Handler<T> delegate) {
            this.delegate = delegate;
        }

        private void setNext(final HandlerImpl<T> next) {
            this.next = next;
        }

        @Override
        public boolean handle(final T t) {
            return delegate.handle(t) || next != null && next.handle(t);
        }

        @Override
        public boolean handleTwo(T request) {
            return delegate.handleTwo(request) || next != null && next.handleTwo(request);
        }
    }


}
