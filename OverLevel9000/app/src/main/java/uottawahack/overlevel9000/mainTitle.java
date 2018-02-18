package uottawahack.overlevel9000;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arsalan Sadiq on 2/17/2018.
 */

public class mainTitle  {
        static mainTitle _mainTitle;
        List<upperTitle> _upperTitle;

        public mainTitle(Context context) {
            _upperTitle = new ArrayList<>();
            for(int i=1;i<=10;i++)
            {
                upperTitle title = new upperTitle(String.format("Name of Patient,Token: #%d",i));
                _upperTitle.add(title);
            }
        }

        public static mainTitle get(Context context)
        {
            if(_mainTitle == null)
                _mainTitle = new mainTitle(context);
            return _mainTitle;
        }

        public List<upperTitle> getAll() {
            return _upperTitle;
        }
    }
