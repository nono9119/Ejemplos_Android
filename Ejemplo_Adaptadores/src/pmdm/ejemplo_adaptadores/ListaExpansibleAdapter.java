package pmdm.ejemplo_adaptadores;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ListaExpansibleAdapter extends BaseExpandableListAdapter
{
	private ArrayList<String> groups;
	private ArrayList<ArrayList<ArrayList<String>>> children;
	private Context context;
	
	public ListaExpansibleAdapter(Context context, ArrayList<String> grupos, ArrayList<ArrayList<ArrayList<String>>> hijos)
	{
		this.context = context;
		this.groups = grupos;
		this.children = hijos;
	}
	
	@Override
	public boolean areAllItemsEnabled()
	{
		return true;
	}
	
	@Override
	public ArrayList<String> getChild(int groupPosition, int childPosition)
	{
		return children.get(groupPosition).get(childPosition);
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return childPosition;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
	{
		String hijo = (String) ((ArrayList<String>)getChild(groupPosition, childPosition)).get(0);
		
		if (convertView == null) // no se recicla el elemento, es nuevo
		{
			LayoutInflater infallInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infallInflater.inflate(R.layout.expandiblelistview_hijo, null);
		}
		
		TextView hijotxt = (TextView) convertView.findViewById(R.id.TextViewHijo01);
		hijotxt.setText(hijo);
		return convertView;
	}
	
	@Override
	public int getChildrenCount(int groupPosition)
	{
		return children.get(groupPosition).size();
	}
	
	@Override
	public String getGroup(int groupPosition)
	{
		return groups.get(groupPosition);
	}
	
	@Override
	public int getGroupCount()
	{
		return groups.size();
	}
	
	@Override
	public long getGroupId(int groupPosition)
	{
		return groupPosition;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
	{
		String group = (String) getGroup(groupPosition);
		
		if (convertView == null) // no se esta reciclando, esta vacio y hay que crearlo de nuevo
		{
			LayoutInflater infallInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infallInflater.inflate(R.layout.expandiblelistview_grupo, null);
		}
		
		TextView grouptxt = (TextView) convertView.findViewById(R.id.TextViewGrupo);
		grouptxt.setText(group);
		return convertView;
	}
	
	@Override
	public boolean hasStableIds()
	{
		return true;
	}
	
	@Override
	public boolean isChildSelectable(int arg0, int arg1)
	{
		return true;
	}
}
