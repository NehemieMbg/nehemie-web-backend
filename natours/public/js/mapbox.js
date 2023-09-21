/* eslint-disable */

console.log('Hello from the client side');
const locations = JSON.parse(document.getElementById('map').dataset.locations);
console.log(locations);

mapboxgl.accessToken =
  'pk.eyJ1IjoibmVoZW1pZSIsImEiOiJjbG1zb2s2dHgwbHg2Mm1tbXRoc3Q1aXhjIn0.C47x0FnWZj2JlcxmhB1icQ';
var map = new mapboxgl.Map({
  container: 'map',
  style: 'mapbox://styles/nehemie/clmsqbih402bl01queyihe3yn',
  scrollZoom: false,
  //   center: [-118.243188, 33.831094],
  //   zoom: 10,
  //   interactive: false,
});

const bounds = new mapboxgl.LngLatBounds();

locations.forEach((loc) => {
  // Create marker
  const el = document.createElement('div');
  el.className = 'marker';

  // Add marker
  new mapboxgl.Marker({
    element: el,
    anchor: 'bottom',
  })
    .setLngLat(loc.coordinates)
    .addTo(map);

  // Add popup
  new mapboxgl.Popup({
    offset: 30,
  })
    .setLngLat(loc.coordinates)
    .setHTML(`<p>Day ${loc.day}: ${loc.description}</p>`)
    .addTo(map);

  // Extend map bounds to include current location
  bounds.extend(loc.coordinates);
});

map.fitBounds(bounds, {
  padding: {
    top: 200,
    bottom: 150,
    left: 100,
    right: 100,
  },
});
