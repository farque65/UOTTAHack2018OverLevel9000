package uottawahack.overlevel9000;

/**
 * Created by Arsalan Sadiq on 2/17/2018.
 */

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class LowerView  extends ChildViewHolder {
        public TextView option1,option2;
        public LowerView (View itemView) {
            super(itemView);
            option1 = (TextView)itemView.findViewById(R.id.option1);
            option2 = (TextView)itemView.findViewById(R.id.option2);
        }
}
