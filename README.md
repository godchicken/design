## Requirements

### NodeJS

Required version : 0.10.22

## Usage

With SVGUtils you can :

+   Convert SVG Document to JSON
+   Convert JSON to SVG Document
+   Manipulate Svg
+   Use Matrix to SVG or elements
+   ...

#### Warning

For Text and Group, the boundingbox result is not true but it's enough for basic manipulations

### Loading SVG file

```javascript
var Svg = require('svgutils').Svg;


Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    // ...
});
```

### Convert SVG file to JSON

```javascript
var Svg = require('svgutils').Svg;

Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    if(err){
        throw new Error('SVG file not found or invalid');
    }

    var json = svg.toJSON();
});
```

### Apply Matrix and get transformed svg

#### Currents Matrix only

```javascript
var Svg = require('svgutils').Svg;

Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    if(err){
        throw new Error('SVG file not found or invalid');
    }

    svg.applyMatrix(null, function(newSvg){
        console.log(newSvg.toString());
    });
});
```

#### Externals and currents Matrix

```javascript
var Svg     = require('svgutils').Svg,
    Matrix  = require('svgutils';.Matrix;

Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    if(err){
        throw new Error('SVG file not found or invalid');
    }

    // Ex : apply translate(10, 20) to all svg
    svg.applyMatrix(new Matrix(1, 0, 0, 1, 10, 20), function(newSvg){
        console.log(newSvg.toString());
    });
});
```

### Save generated SVG or Convert to PNG

#### Save SVG

```javascript
var Svg     = require('svgutils').Svg,
    Matrix  = require('svgutils';.Matrix;

Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    if(err){
        throw new Error('SVG file not found or invalid');
    }

    svg.save({ output : '/home/user/svg.svg' }, function(err, filename){
        if(err){
            throw err;
        }
    });
});
```

#### Save PNG

```javascript
var Svg     = require('svgutils').Svg,
    Matrix  = require('svgutils';.Matrix;

Svg.fromSvgDocument(__dirname + '/test2.svg', function(err, svg){
    if(err){
        throw new Error('SVG file not found or invalid');
    }

    svg.savePng({ output : '/home/user/svg.png' }, function(err, filename){
        if(err){
            throw err;
        }
    });
});
```

### Convert others formats to SVG

#### DXF to SVG (thanks to Thomas Desmoulin and his [DXF-parsing module](https://github.com/thomasdesmoulin/dxf-parsing))

You can create SVG from DXF file. You can, as you want, get specifics DXF layers.

```javascript
Svg.fromDxfFile({
    path : __dirname + '/test.dxf'
}, function (err, svg) {
    if(err){
        throw new Error('SVG file not found or invalid');
    }
    
    // your converted svg
});