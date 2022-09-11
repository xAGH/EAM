year = 2016

def is_leap_year(year):
    return year % 100 != 0 and year % 4 == 0

print(is_leap_year(year))