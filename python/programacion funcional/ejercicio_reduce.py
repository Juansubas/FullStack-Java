from functools import reduce

lista = ['Python', 'Java', 'JavaScript', 'Dart', 'Ruby', 'Elixir']

separar = lambda ac, e: ac+' - '+e
print( reduce( separar, lista) )