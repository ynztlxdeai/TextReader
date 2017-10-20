
package com.luoxiang.reader.component;

import com.luoxiang.reader.ui.activity.MainActivity;
import com.luoxiang.reader.ui.activity.SettingActivity;
import com.luoxiang.reader.ui.activity.WifiBookActivity;
import com.luoxiang.reader.ui.fragment.RecommendFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity activity);

    RecommendFragment inject(RecommendFragment fragment);

    SettingActivity inject(SettingActivity activity);
    WifiBookActivity inject(WifiBookActivity activity);
}