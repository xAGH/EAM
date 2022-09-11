def himming(first_word, second_word):
    if check_length(first_word, second_word):
        distance = 0
        position = len(first_word) - 1
        first_word, second_word = first_word.upper(), second_word.upper()
        while position != 0:
            if first_word[position] != second_word[position]:
                distance += 1
            position -= 1
        print("Himming Distance: ", distance)
    else:
        print("Strings length are not equal.")

def check_length(string1, string2):
    return len(string1) == len(string2)

first_word = input("Enter first word: ")
second_word = input("Enter second word: ")

himming(first_word, second_word)