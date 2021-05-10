package com.example.myapplication.adapter

import com.example.myapplication.data.local.ContentEntity

interface DataCallback  {
    fun onItemClicked(content: ContentEntity)
}