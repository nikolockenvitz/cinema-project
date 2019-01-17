# Template der Kinente-API

## movie/getAllMovies
```JSON
[
  {
  id: ...,
  name: ...,
  genres: [
      {
      name: ...
      },
      ...
    ],
  fsk: ...,
  length: ...,
  description: ...,
  actors: [
      {
        firstName: ...,
        lastName: ...,
        birthdate: ...,
        ...
      },
    ...
    ]
  },
  ...
]
```

## movie/*< movieID >*
```JSON
{
  movie: {
    id: ...,
    name: ...,
    genres: [
      {
        name: ...
      },
    ...
    ],
    fsk: ...,
    length: ...,
    description: ...,
    actors: [
      {
        firstName: ...,
        lastName: ...,
        birthdate: ...,
        ...
      },
      ...
    ]
  }
  shows: [
    {
      id: ...,
      date: ...,
      time: ...,
      is3D: ...,
      hall: {...}
    },
    ...
  ]
}
```

## show/*< showID >*

```JSON

{
  movie: {
    id: ...,
    name: ...,
    genres: [
      {
        name: ...
      },
    ...
    ],
    fsk: ...,
    duration: ...,
    description: ...,
    actors: [
      {
        firstName: ...,
        lastName: ...,
        birthdate: ...,
        ...
      },
      ...
    ]
  },
  show: {
    id: ...,
    date: ...,
    time: ...,
    is3D: ...,
    hall: {...},
    seats: [
      {
        x: ...,
        y: ...,
        id: ...,
        row: ...,
        number: ...,
        category: ...,
        isOccupied: ...,
        isBlocked: ...,
        price: {
          defaultPrice: ...,
          reducedPrice: ...
        }
      }
    ]
  }
}
```

## book
```JSON
{
  id: ...,
  method: ...,
  user: {},
  seats[],
  showID: ...,
  method: ...,
  verification: ...
}
```