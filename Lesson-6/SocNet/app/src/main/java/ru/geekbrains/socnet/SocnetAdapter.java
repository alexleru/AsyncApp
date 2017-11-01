
package ru.geekbrains.socnet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// адаптер
public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {
    private String[] data;

    // этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // Один пункт списка.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Каждый пункт списка в нашем случае это строка.
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    public SocnetAdapter(String[] data) {
        this.data = data;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    public SocnetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // Создаём новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // Здесь можно установить всякие параметры
        ViewHolder vh = new ViewHolder((TextView) v);
        return vh;
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Получить элемент из источника данных (БД, интернет…)
        // Вынести на экран используя ViewHolder
        holder.textView.setText(data[position]);

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return data.length;
    }
}
