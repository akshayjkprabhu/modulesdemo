package com.android.example.base.data.model;


public class UiHelper {
    boolean mbShowProgress = false;
    boolean mbShowEmptyView = false;
    Error error;

    UiHelper(UiHelperBuilder builder) {
        mbShowProgress = builder.mbShowProgress;
        mbShowEmptyView = builder.mbShowEmptyView;
        this.error = builder.error;
    }

    public boolean isMbShowProgress() {
        return mbShowProgress;
    }

    public Error getError() {
        return error;
    }

    public boolean isMbShowEmptyView() {
        return mbShowEmptyView;
    }

    public static class UiHelperBuilder {
        boolean mbShowProgress;
        Error error;
        boolean mbShowEmptyView;

        public UiHelperBuilder showProgress(boolean show) {
            mbShowProgress = show;
            return this;
        }

        public UiHelperBuilder setMbShowProgress(boolean mbShowProgress) {
            this.mbShowProgress = mbShowProgress;
            return this;
        }

        public UiHelperBuilder setError(Error error) {
            this.error = error;
            return this;
        }

        public UiHelperBuilder setMbShowEmptyView(boolean mbShowEmptyView) {
            this.mbShowEmptyView = mbShowEmptyView;
            return this;
        }

        public UiHelper build() {
            return new UiHelper(this);
        }

    }
}
