package com.tiago.masterdetail.data

/**
 * Created by tiago on 18/02/18.
 */
class Person {
    var id: Number? = null
    var name: String? = null
    var email: String? = null

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    constructor(id: Number?, name: String?, email: String?) {
        this.name = name
        this.email = email
    }
}