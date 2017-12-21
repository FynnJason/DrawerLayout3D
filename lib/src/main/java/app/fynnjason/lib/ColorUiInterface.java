package app.fynnjason.lib;

import android.content.res.Resources;
import android.view.View;

public interface ColorUiInterface {

    View getView();

    void setTheme(Resources.Theme themeId);
}
