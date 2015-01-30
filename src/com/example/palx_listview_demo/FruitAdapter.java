package com.example.palx_listview_demo;

import java.util.List;

import android.R.layout;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {

	private int resourceId;

	public FruitAdapter(Context context, int textViewResourceId,
			List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Fruit fruit = getItem(position);// 获取当前项的friut实例
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.fruitImage = (ImageView) view
					.findViewById(R.id.fruit_image);
			viewHolder.fruitName = (TextView) view
					.findViewById(R.id.fruit_name);
			view.setTag(viewHolder);// 将viewHolder存储在view中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();// 重新获取ViewHolder
		}

		viewHolder.fruitName.setText(fruit.getName());
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		return view;
	}

	class ViewHolder {
		ImageView fruitImage;
		TextView fruitName;
	}

}
