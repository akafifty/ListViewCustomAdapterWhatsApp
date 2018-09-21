package lvp.iso.com.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;

    public static final String TEXTO = "texto";
    public static final String AUDIO = "audio";
    public static final String IMAGEN = "imagen";
    public static final String VIDEO = "video";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        this.listView.setNestedScrollingEnabled(true);
        this.listView.setAdapter(customAdapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init() {
        this.listView = findViewById(R.id.listView);
        this.customAdapter = new CustomAdapter(this, getArrayList());
    }

    private String getEmoji(int unicode) {
        return new String(Character.toChars(unicode));
    }

    private ArrayList<ObjetoListView> getArrayList() {

        ArrayList<ObjetoListView> arrayList = new ArrayList<>();

        //MENSAJE NO LEIDO
        arrayList.add(new ObjetoListView("Familia" + getEmoji(0x1F601), "Juan: " + getEmoji(0x1F64C),
                "10/8/18", TEXTO, false, 3, "", R.drawable.img_1));
        //AUDIO
        arrayList.add(new ObjetoListView("Alicia", "",
                "4/8/18", AUDIO, false, 1, "0:34", R.drawable.img_2));
        //PHOTO
        arrayList.add(new ObjetoListView("Juan", "",
                "AYER", IMAGEN, true, 1, "Foto", R.drawable.img_3));
        //VIDEO
        arrayList.add(new ObjetoListView("Amaya", "",
                "JUEVES", VIDEO, true, 1, "Video", R.drawable.img_4));
        //TXT
        arrayList.add(new ObjetoListView("Comida",
                "tú: ¡Me parece genial!" + getEmoji(0x1F60A),
                "2/8/18", TEXTO, true, 1, "", R.drawable.img_5));

        //TXT
        arrayList.add(new ObjetoListView("Diana",
                "Nos vemos el viernes " + getEmoji(0x1F60A),
                "2/8/18", TEXTO, true, 1, "", R.drawable.img_3));


        return arrayList;
    }

}
