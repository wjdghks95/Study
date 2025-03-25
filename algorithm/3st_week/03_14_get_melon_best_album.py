def get_melon_best_album(genre_array, play_array):
    '''
    result = []

    dict = {}.fromkeys(genre_array, 0)
    for i in range(len(genre_array)):
        dict[genre_array[i]] += play_array[i]

    while dict:
        max = 0
        max_key = ""
        for key in dict.keys():
            if max < dict[key]:
                max = dict[key]
                max_key = key

        dict.pop(max_key)

        count_list = []
        for i in range(len(genre_array)):
            if genre_array[i] == max_key:
                count_list.append(play_array[i])

        count_list.sort(reverse=True)

        for i in range(2):
            index = play_array.index(count_list[i])
            result.append(index)

    return result
    '''

    result = []

    n = len(genre_array)
    genre_total_play_dict = {}
    genre_index_play_array_dict = {}

    for i in range(n):
        genre = genre_array[i]
        play = play_array[i]

        if genre in genre_total_play_dict:
            genre_total_play_dict[genre] += play
            genre_index_play_array_dict[genre].append([i, play])

        else:
            genre_total_play_dict[genre] = play
            genre_index_play_array_dict[genre] = [[i, play]]

    print(genre_total_play_dict)
    print(genre_index_play_array_dict)

    sorted_genre_play_array = sorted(genre_total_play_dict.items(), key=lambda item: item[1], reverse=True)
    for genre, total_play in sorted_genre_play_array:

        genre_song_count = 0
        sorted_genre_index_play_array = sorted(genre_index_play_array_dict[genre], key=lambda item: item[1], reverse=True)
        for index, play in sorted_genre_index_play_array:
            if genre_song_count >= 2:
                break

            result.append(index)
            genre_song_count += 1

    return result

print("정답 = [4, 1, 3, 0] / 현재 풀이 값 = ", get_melon_best_album(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
print("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = ", get_melon_best_album(["hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"], [2000, 500, 600, 150, 800, 2500, 2000]))