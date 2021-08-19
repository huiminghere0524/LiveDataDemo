package my.edu.tarc.livedatademo

import android.provider.LiveFolders
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    var owner : String = ""
    private var _balance = MutableLiveData<Double>()
    val balance: LiveData<Double>
                get()=_balance

    // var balance: Double = 0.0
//LiveData cannot updated/changed
// MutableLiveData can change/ updated

    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
       // this.balance = balance
    }

    fun deposit(amount: Double) {
        _balance.value = (_balance.value)?.plus(amount)
        //balance +- amount
    }

    fun withdraw(amount:Double){
        _balance.value = (_balance.value)?.minus(amount)
        //balance +- amount
    }

}