def flip_horizontal(grid: list):
    row_copy = [grid[0][0], grid[0][1]]
    grid[0][0] = grid[1][0]
    grid[0][1] = grid[1][1]
    grid[1][0] = row_copy[0]
    grid[1][1] = row_copy[1]


def flip_vertical(grid: list):
    column_copy = [grid[0][0], grid[1][0]]
    grid[0][0] = grid[0][1]
    grid[1][0] = grid[1][1]
    grid[0][1] = column_copy[0]
    grid[1][1] = column_copy[1]


def flip_grid(flips: str):
    grid = [["1", "2"],["3", "4"]]
    for c in flips:
        if c == 'H':
            flip_horizontal(grid)
        if c == 'V':
            flip_vertical(grid)
    print(grid[0][0], end=" ")
    print(grid[0][1], end="")
    print()
    print(grid[1][0], end=" ")
    print(grid[1][1], end="")


flips = input()
flip_grid(flips)
