precision mediump float;

uniform sampler2D texture;
varying lowp vec2 frag_coordinate;
varying lowp vec4 frag_color;

void main() {
//    gl_FragColor = frag_color;
//    gl_FragColor = frag_color * texture2D(texture, frag_coordinate);
    gl_FragColor = texture2D(texture, frag_coordinate);
}
