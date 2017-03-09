package Fragment;

import com.example.mcjourney.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainTabbarFragment extends Fragment {

	View btnSMenu, tabMain, tabItem, tabGroup, btnSearch;
	View[] tabs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_tabbar, null);

		btnSMenu = view.findViewById(R.id.btn_SMenu);
		btnSearch = view.findViewById(R.id.btn_search);
		tabMain = view.findViewById(R.id.tab_main);
		tabItem = view.findViewById(R.id.tab_item);
		tabGroup = view.findViewById(R.id.tab_group);

		tabs = new View[] { tabMain, tabItem, tabGroup };

		for (final View tab : tabs) {
			tab.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					onTabClicked(tab);
				}
			});
		}
		return view;
	}

	protected void onTabClicked(View tab) {
		// TODO Auto-generated method stub
		int selectedIndex = -1;
		for (int i = 0; i < tabs.length; i++) {
			View otherTab = tabs[i];
			if (otherTab == tab) {
				otherTab.setSelected(true);
				selectedIndex = i;
			} else {
				otherTab.setSelected(false);
			}
		}
		if (OnSelectedListener != null && selectedIndex >= 0) {
			OnSelectedListener.OnGoTabClicked(selectedIndex);
		}
	}

	public void setSelectedItem(int index) {
		if (index >= 0 && index < tabs.length) {
			onTabClicked(tabs[index]);
		}
	}

	// ¶¨Áx½Ó¿Ú
	public static interface OnSelectedListener {
		void OnGoTabClicked(int index);
	}

	OnSelectedListener OnSelectedListener;

	public void OnSelectedListener(OnSelectedListener OnSelectedListener) {
		this.OnSelectedListener = OnSelectedListener;
	}

	public int getSelectedIndex() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tabs.length; i++) {
			if (tabs[i].isSelected())
				return i;
		}
		return -1;
	}
}
