package uottawahack.overlevel9000;

/**
 * Created by Arsalan Sadiq on 2/17/2018.
 */

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

public class UpperView  extends ParentViewHolder {
        public TextView _textView;
        public ImageButton _imageButton;

        public UpperView(View itemView) {
            super(itemView);
            _textView = (TextView)itemView.findViewById(R.id.parentTitle);
            _imageButton = (ImageButton) itemView.findViewById(R.id.expandArrow);
        }
    }
