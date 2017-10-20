package _03

/**
 * Created by dysania on 20/10/2017.
 */

class User(val id: Int, val name: String, val address: String)

// 3.11 带重复代码的函数
fun saveUser(user: User) {
    // 重复的字段检查
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty address")
    }

    // 保存 user 到数据库
}

// 3.12 提取局部函数来避免重复
fun saveUserTidy1(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "name")
    validate(user, user.address, "address")

    // 保存 user 到数据库
}

// 3.13 在局部函数中访问外层函数的参数
fun saveUserTidy2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            // 可以直接访问外部函数的参数
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }

    }

    validate(user.name, "name")
    validate(user.address, "address")

    // 保存 user 到数据库
}

// 3.14 提取逻辑到扩展函数
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")     //可以直接访问 user 的属性
        }
    }

    validate(name, "name")
    validate(address, "address")
}

fun saveUserTidy3(user: User) {
    user.validateBeforeSave()

    // 保存 user 到数据库
}

fun main(args: Array<String>) {
//    saveUser(User(1, "", ""))
//    saveUserTidy1(User(1, "", ""))
//    saveUserTidy2(User(1, "", ""))
    saveUserTidy3(User(1, "", ""))
}