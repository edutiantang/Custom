package wang.condon.customdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.support.v7.app.AlertDialog.Builder;

public class MainActivity extends Activity {

	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFruits();
		FruitAdapter adapter = new FruitAdapter(MainActivity.this,
				R.layout.fruit_item, fruitList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/*Fruit fruit = fruitList.get(position);
				Toast.makeText(MainActivity.this, fruit.getName(),
						Toast.LENGTH_SHORT).show();*/
                showDialog();

			}
		});

	}

    /**
     * 这是兼容的 AlertDialog
     */
    private void showDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View   dialog = inflater.inflate(R.layout.dialog,(ViewGroup) findViewById(R.id.dialog));
        final EditText editText = (EditText) dialog.findViewById(R.id.et);

        AlertDialog alertDialog = new Builder(this)
        .setTitle("Material Design Dialog")
        .setMessage("这是 android.support.v7.app.AlertDialog 中的样式")
        .setView(dialog)
        .setNegativeButton("取消", null)
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        })
        .create();
        alertDialog.show();
        alertDialog.getButton(BUTTON_POSITIVE).setTextColor(Color.BLUE);
        alertDialog.getButton(BUTTON_NEGATIVE).setTextColor(Color.GRAY);
    }

	private void initFruits() {
		Fruit apple = new Fruit("Apple", R.drawable.apple_pic, 3);
		fruitList.add(apple);
		Fruit banana = new Fruit("Banana", R.drawable.banana_pic, 4);
		fruitList.add(banana);
		Fruit orange = new Fruit("Orange", R.drawable.orange_pic, 5);
		fruitList.add(orange);
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic, 5);
		fruitList.add(watermelon);
		Fruit pear = new Fruit("Pear", R.drawable.pear_pic, 5);
		fruitList.add(pear);
		Fruit grape = new Fruit("Grape", R.drawable.grape_pic, 5);
		fruitList.add(grape);
		Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic, 5);
		fruitList.add(pineapple);
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic, 5);
		fruitList.add(strawberry);
		Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic, 5);
		fruitList.add(cherry);
		Fruit mango = new Fruit("Mango", R.drawable.mango_pic, 5);
		fruitList.add(mango);
	}

}