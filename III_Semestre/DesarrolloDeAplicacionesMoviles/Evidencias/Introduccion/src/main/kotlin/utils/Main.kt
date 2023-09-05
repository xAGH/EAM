package utils;

fun printUI(welcomeMessage: String, options: Map<String, () -> Unit>, withExit: Boolean = true) {
    var menu: String = "\n$welcomeMessage\n";
    val keys: Set<String> = options.keys;
    for ((index, option) in keys.withIndex()) { menu += "${index + 1}. ${option}\n" }
    if (withExit) menu += "0. Salir.\n";
    menu += "> "
    do {
        print(menu);
        val option = try { readln().toInt(); } catch (_: NumberFormatException) { -1; };
        val keep = onOptionSelect(option, options);
    } while(keep);
}

private fun onOptionSelect(option: Int, options: Map<String, () -> Unit>): Boolean {
    return try {
        options.getOrDefault(options.keys.elementAt(option - 1), {})()
        true;
    } catch (_: IndexOutOfBoundsException) {
        false;
    }
}