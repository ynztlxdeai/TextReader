
package com.luoxiang.reader.api.support;

import com.luoxiang.reader.utils.LogUtils;

public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.i("http : " + message);
    }
}
