package net.println.kotlin.dslDemo

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/9/19.
 */
class MapDelegate(val map: MutableMap<String,String>): ReadWriteProperty<Any,String>{
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return map[property.name]?:""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name] = value
    }
}