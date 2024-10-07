package com.example.oop

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),OnClickListener,OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txv : TextView=findViewById(R.id.txv)
        /*txv.text= "OOP example"
        var v1=Two()
        v1.x=7
        v1.y=5
        var v2=Two()
        v2.x=55
        v2.y=7*/
        //var v3=Two(x=46,y=8)
        var v3=Three(x=55,y=6,z=21)
        txv.text=/*v1.Sum().toString()+";"+*/v3.Sum().toString()+"\n"+v3.Ave().toString()
        var img:ImageView=findViewById(R.id.img)
        img.setOnClickListener(this)
        txv.setOnClickListener(this)
        img.setOnLongClickListener(this)

    }

    override fun onClick(v: View?) {
        var txv : TextView=findViewById(R.id.txv)
        if(v==txv){
            txv.text="短按文字"
        }
        else {
            txv.text = "RAWRRRRRRRRRRRRRRRRRR"
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        var txv : TextView=findViewById(R.id.txv)
        txv.text="長按呆腦獸"
        return false
    }
}
interface Average{
    fun Ave():Float
}
open class Two(var x:Int,var y:Int){
    open fun Sum():Int{
        return x+y
    }
}
class Three(x:Int,y:Int,var z:Int) : Two(x,y),Average{
    override fun Sum():Int{
        return x+y+z
    }

    override fun Ave(): Float {
        return (x+y+z).toFloat()/3
    }
}
/*class Two{
    var x:Int=0
    var y:Int=0
    fun Sum():Int{
        return x+y
    }
} */
