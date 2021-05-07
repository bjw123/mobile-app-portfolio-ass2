package com.example.to_do_list

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoAdapter (private val todos: MutableList<Todo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder { //default display
        return ToDoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    fun addTodo(todo: Todo){
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos(){
        todos.removeAll{ todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvToDoTitle: TextView, isChecked: Boolean){
        if(isChecked){
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else{
            tvToDoTitle.paintFlags = tvToDoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {//when new item is added
        val curTodo = todos[position]
        holder.itemView.apply { tvToDoTitle.text = curTodo.title
        cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvToDoTitle, curTodo.isChecked)
        cbDone.setOnCheckedChangeListener{ _, isChecked ->
            toggleStrikeThrough(tvToDoTitle, isChecked)
            curTodo.isChecked = !curTodo.isChecked
        }
        }

    }

    override fun getItemCount(): Int {
        return todos.size //return size
    }
}