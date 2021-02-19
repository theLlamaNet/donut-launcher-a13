/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ussr.razar.android.dount.launcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.*

/**
 * GridView adapter to show the list of applications and shortcuts
 */
class ApplicationsAdapter constructor(context: Context, apps: ArrayList<ApplicationInfo>) :
    ArrayAdapter<ApplicationInfo>(context, 0, apps) {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView: View? = convertView
        val info: ApplicationInfo? = getItem(position)
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.application_boxed, parent, false)
        }
        if (!info!!.filtered) {
            info.icon = Utilities.createIconThumbnail(info.icon, context)
            info.filtered = true
        }
        val textView: TextView = convertView as TextView
        textView.setCompoundDrawablesWithIntrinsicBounds(null, info.icon, null, null)
        textView.text = info.title
        return convertView
    }

}