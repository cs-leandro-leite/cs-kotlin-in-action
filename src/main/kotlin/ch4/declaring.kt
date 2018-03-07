package ch4

/*
    Don’t declare multiple secondary constructors to overload and provide
    default values for arguments. Instead, specify default values directly.
    But there are still situations when multiple constructors are required.
 */

class Context()
class AttributeSet()

open class AndroidView {
    constructor(ctx: Context) { //Secondary constructor
        /* .. */
    }
    constructor(ctx: Context, attr: AttributeSet) { //Secondary constructor
        /* .. */
    }
}

class AndroidButton : AndroidView {
    constructor(ctx: Context)
            : super(ctx) {
        /* .. */
    }
    constructor(ctx: Context, attr: AttributeSet)
            : super(ctx, attr) {
        /* .. */
    }
}