
package com.luoxiang.reader.component;

import android.content.Context;

import com.luoxiang.reader.api.BookApi;
import com.luoxiang.reader.module.AppModule;
import com.luoxiang.reader.module.BookApiModule;

import dagger.Component;

@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}