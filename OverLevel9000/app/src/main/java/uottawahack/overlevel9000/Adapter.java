package uottawahack.overlevel9000;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by Arsalan Sadiq on 2/18/2018.
 */

public class Adapter  extends ExpandableRecyclerAdapter<UpperView,LowerView> {

        LayoutInflater inflater;

        List<ParentObject> parentObjectList;


        public Adapter(Context context, List<ParentObject> parentItemList) {
            super(context, parentItemList);
            this.parentObjectList = parentItemList;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public UpperView onCreateParentViewHolder(ViewGroup viewGroup) {
            View view = inflater.inflate(R.layout.cardviewlisting,viewGroup,false);
            return new UpperView(view);
        }

        @Override
        public LowerView onCreateChildViewHolder(ViewGroup viewGroup) {
            View view = inflater.inflate(R.layout.cardviewlayout,viewGroup,false);
            return new LowerView(view);
        }

        @Override
        public void onBindParentViewHolder(UpperView UpperView, int i, Object o) {
            upperTitle title = (upperTitle)o;
            Log.d("help", String.valueOf(title));
            UpperView._textView.setText(title.getTitle());

        }

        @Override
        public void onBindChildViewHolder(LowerView lowerView, int i, Object o) {
            lowTitle lowTitle = ( lowTitle)o;
            lowerView.option1.setText(lowTitle.getOption1());
            lowerView.option2.setText(lowTitle.getOption2());

        }

       //@Override
       // public int getItemCount() {
        //    return parentObjectList.size();
        //}


    }
