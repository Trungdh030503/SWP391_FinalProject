function sprops(a) {
    var b, c = "";
    for (b in a) {
        c += "<br />" + b + ":";
        try {
            c += a[b]
        } catch (a) {}
    }
    var d = document.createElement("div");
    d.innerHTML = c,
    document.body.appendChild(d)
}
var vZoom = {
    images: new Object,
    zoomArea: null,
    mouse: {
        left: 0,
        top: 0
    },
    displayImage: null,
    magnifyingGlass: null,
    magnifyingGlassImage: null,
    transparentOverlay: null,
    loadingArea: null,
    loadingAreaImage: null,
    iframe: null,
    fader: null,
    identity: -1,
    dontHide: !0,
    activeProperties: {
        image: null,
        zoomImage: null,
        imagePlacement: null,
        scaleX: 0,
        scaleY: 0,
        magnifyingGlassBorderWidth: 0,
        imageBorderWidth: 0
    },
    matchImage: !0,
    fadeSpeed: 15,
    fadeStrength: 5,
    offsetX: 0,
    offsetY: 0,
    init: function() {
        vZoom.magnifyingGlass || (vZoom.magnifyingGlass = document.createElement("div"),
        vZoom.magnifyingGlass.id = "vZoomMagnifier",
        vZoom.magnifyingGlass.style.position = "absolute",
        vZoom.magnifyingGlassImage = document.createElement("img"),
        vZoom.magnifyingGlassImage.alt = "",
        vZoom.magnifyingGlassImage.id = "vZoomMagnifierImage",
        vZoom.magnifyingGlassImage.style.position = "absolute",
        vZoom.magnifyingGlass.appendChild(vZoom.magnifyingGlassImage),
        vZoom.zoomArea = document.createElement("div"),
        vZoom.zoomArea.id = "vZoomArea",
        vZoom.zoomArea.style.display = "none",
        vZoom.zoomArea.style.position = "absolute",
        vZoom.zoomArea.style.overflow = "hidden",
        vZoom.zoomArea.style.zIndex = 5,
        vZoom.displayImage = document.createElement("img"),
        vZoom.displayImage.alt = "",
        vZoom.displayImage.style.position = "absolute",
        vZoom.zoomArea.appendChild(vZoom.displayImage),
        vZoom.transparentOverlay = document.createElement("div"),
        vZoom.transparentOverlay.id = "vZoomTransparentOverlay",
        vZoom.transparentOverlay.style.display = "none",
        vZoom.transparentOverlay.style.position = "absolute",
        vZoom.loadingArea = document.createElement("div"),
        vZoom.loadingArea.id = "vZoomLoadingArea",
        vZoom.loadingArea.style.display = "none",
        vZoom.loadingArea.style.position = "absolute",
        vZoom.loadingArea.style.zIndex = "1",
        vZoom.loadingArea.appendChild(vZoom.loadingAreaImage),
        vZoom.iframe = document.createElement("iframe"),
        vZoom.iframe.frameBorder = 0,
        vZoom.iframe.style.display = "none",
        vZoom.iframe.style.position = "absolute",
        vZoom.iframe.style.zIndex = 4,
        document.body.appendChild(vZoom.transparentOverlay),
        document.body.appendChild(vZoom.magnifyingGlass),
        document.body.appendChild(vZoom.zoomArea),
        document.body.appendChild(vZoom.loadingArea),
        document.body.appendChild(vZoom.iframe),
        vZoom.setDefaults())
    },
    setDefaults: function() {
        if ("string" != typeof vQwfdiUKfgdfP) {
            var a = vZoom.zoomArea.style
              , b = vZoom.magnifyingGlass.style
              , c = vZoom.transparentOverlay.style;
            a.borderWidth = "1px",
            a.borderColor = "#c1c1c1",
            a.borderStyle = "solid",
            b.borderWidth = "1px",
            b.borderColor = "#c1c1c1",
            b.borderStyle = "solid",
            b.cursor = "pointer",
            b.overflow = "hidden",
            c.opacity = "0.50",
            c.backgroundColor = "#cccccc",
            c.filter = "alpha(opacity=50)",
            c.cursor = "pointer",
            vZoom.matchImage = !0,
            vZoom.fadeSpeed = 15,
            vZoom.fadeStrength = 5,
            vZoom.offsetX = 0,
            vZoom.offsetY = 0
        }
    },
    findZoomImage: function(a) {
        return a = a.toLowerCase(),
        a = a.replace("t.jpg", ".jpg"),
        a = a.replace("-.jpg", ".jpg"),
        a = a.replace("t.gif", ".gif"),
        a = a.replace("-.gif", ".gif")
    },
    filter: function(a) {
        return a.toLowerCase()
    },
    add: function(a, b) {
        a = v$(a),
        a.onmouseover = vZoom.onmouseover,
        vZoom.loadingAreaImage || (vZoom.loadingAreaImage = document.createElement("img"),
        vZoom.loadingAreaImage.src = "/a/i/vzoom.gif"),
        null != b ? vZoom.preloadImage(a.src, b) : vZoom.preloadImage(a.src, vZoom.findZoomImage(a.src)),
        a.onload = null
    },
    preloadImage: function(a, b) {
        if (a && b) {
            var c = new Image
              , d = new Image;
            d.onerror = function(a) {
                d.onerror = null,
                d.onload = null,
                d = null
            }
            ,
            d.onload = function(a) {
                d.onload = null,
                d.loaded = !0,
                vZoom.activeProperties.zoomImage == d && (vZoom.loadingArea.style.display = "none",
                vZoom.activeProperties.image.onmouseover(a))
            }
            ,
            c.src = a,
            d.src = b;
            var e = vZoom.filter(c.src);
            vZoom.images[e] || (vZoom.images[e] = d)
        }
    },
    fadeIn: function(a) {
        vZoom.fader && (window.clearTimeout(vZoom.fader),
        vZoom.fader = null),
        vZoom.zoomArea.style.opacity = a / 100,
        vZoom.zoomArea.style.filter = "alpha(opacity=" + a + ")",
        vZoom.iframe.style.opacity = a / 100,
        vZoom.iframe.style.filter = "alpha(opacity=" + a + ")",
        a < 100 && (vZoom.fader = window.setTimeout("vZoom.fadeIn(" + (a + vZoom.fadeStrength) + ");", vZoom.fadeSpeed))
    },
    onmouseover: function(a) {
        vZoom.init();
        var b = vZoom.filter(this.src)
          , c = vZoom.images[b];
        if (null != c) {
            vZoom.setDefaults();
            var d = vPlacement(this);
            if (AttachEvent(document, "mousemove", vZoom.onmousemove),
            vZoom.activeProperties.image = this,
            vZoom.activeProperties.zoomImage = c,
            vZoom.activeProperties.imagePlacement = d,
            1 != c.loaded)
                return vZoom.loadingArea.style.display = "",
                vZoom.loadingArea.style.left = d.left + d.width / 2 - vZoom.loadingAreaImage.offsetWidth / 2 + "px",
                void (vZoom.loadingArea.style.top = d.top + d.height / 2 - vZoom.loadingAreaImage.offsetHeight / 2 + "px");
            vZoom.loadingArea.style.display = "none",
            vZoom.displayImage.src != c.src && (vZoom.displayImage.src = c.src),
            vZoom.magnifyingGlassImage.src != this.src && (vZoom.magnifyingGlassImage.src = this.src),
            vZoom.magnifyingGlass.style.display = "",
            vZoom.zoomArea.style.display = "",
            vZoom.transparentOverlay.style.display = "";
            var e = document.documentElement.clientWidth || document.body.clientWidth
              , f = document.documentElement.clientHeight || document.body.clientHeight;
            if (vZoom.matchImage) {
                vZoom.zoomArea.style.width = d.width + "px",
                vZoom.zoomArea.style.height = d.height + "px";
                var g = {
                    width: vZoom.zoomArea.offsetWidth,
                    height: vZoom.zoomArea.offsetHeight
                };
                g.width > d.width && (vZoom.zoomArea.style.width = parseFloat(vZoom.zoomArea.style.width) - (g.width - d.width) + "px"),
                g.height > d.height && (vZoom.zoomArea.style.height = parseFloat(vZoom.zoomArea.style.height) - (g.height - d.height) + "px")
            }
            var g = {
                width: vZoom.zoomArea.offsetWidth,
                height: vZoom.zoomArea.offsetHeight
            }
              , h = d.left + d.width + vZoom.offsetX
              , i = d.top + vZoom.offsetY;
            h + g.width > e && (h = d.left - g.width - vZoom.offsetX,
            i = d.top - vZoom.offsetY,
            h < 0 && (h = d.left + vZoom.offsetX,
            i = d.top + d.height + vZoom.offsetY,
            i + g.height > f && (h = d.left - vZoom.offsetX,
            i = d.top - g.height - vZoom.offsetY,
            i < 0 && (h = d.left + d.width + vZoom.offsetX,
            i = d.top + vZoom.offsetY)))),
            vZoom.zoomArea.style.left = h + "px",
            vZoom.zoomArea.style.top = i + "px";
            var j = vZoom.displayImage.offsetWidth / d.width
              , k = vZoom.displayImage.offsetHeight / d.height;
            if (k < 1.2 || j < 1.2)
                return void vZoom.hide(null, !0);
            vZoom.magnifyingGlassImage.onmousedown = vZoom.activeProperties.image.onmousedown,
            vZoom.magnifyingGlassImage.onmouseup = vZoom.activeProperties.image.onmouseup,
            vZoom.magnifyingGlassImage.onclick = function(a) {
                var a = window.event || a;
                if (vZoom.activeProperties.image.onclick && vZoom.activeProperties.image.onclick(a),
                "A" == vZoom.activeProperties.image.parentNode.nodeName.toUpperCase()) {
                    var b = vZoom.activeProperties.image.parentNode
                      , c = jQuery(b).attr("rel");
                    b.href && "" == c && (window.location.href = b.href),
                    b.click(a)
                }
                return !0
            }
            ,
            vZoom.magnifyingGlass.currentStyle ? (vZoom.activeProperties.magnifyingGlassBorderWidth = parseFloat(vZoom.magnifyingGlass.currentStyle.borderTopWidth) || 0,
            vZoom.activeProperties.imageBorderWidth = parseFloat(this.currentStyle.borderTopWidth) || 0) : document.defaultView && document.defaultView.getComputedStyle ? (vZoom.activeProperties.magnifyingGlassBorderWidth = parseFloat(document.defaultView.getComputedStyle(vZoom.magnifyingGlass, null).getPropertyValue("border-top-width")) || 0,
            vZoom.activeProperties.imageBorderWidth = parseFloat(document.defaultView.getComputedStyle(this, null).getPropertyValue("border-top-width")) || 0) : (vZoom.activeProperties.magnifyingGlassBorderWidth = 0,
            vZoom.activeProperties.imageBorderWidth = 0),
            vZoom.magnifyingGlass.style.width = vZoom.zoomArea.offsetWidth / j + vZoom.activeProperties.magnifyingGlassBorderWidth + "px",
            vZoom.magnifyingGlass.style.height = vZoom.zoomArea.offsetHeight / k + vZoom.activeProperties.magnifyingGlassBorderWidth + "px",
            vZoom.activeProperties.scaleX = j,
            vZoom.activeProperties.scaleY = k,
            vZoom.transparentOverlay.style.left = d.left + vZoom.activeProperties.imageBorderWidth + "px",
            vZoom.transparentOverlay.style.top = d.top + vZoom.activeProperties.imageBorderWidth + "px",
            vZoom.transparentOverlay.style.width = d.width - 2 * vZoom.activeProperties.imageBorderWidth + "px",
            vZoom.transparentOverlay.style.height = d.height - 2 * vZoom.activeProperties.imageBorderWidth + "px",
            vZoom.iframe.style.left = vZoom.zoomArea.style.left,
            vZoom.iframe.style.top = vZoom.zoomArea.style.top,
            vZoom.iframe.style.width = vZoom.zoomArea.offsetWidth,
            vZoom.iframe.style.height = vZoom.zoomArea.offsetHeight,
            vZoom.iframe.style.display = "block",
            vZoom.onmousemove(a),
            c.loaded && vZoom.fadeIn(1)
        }
    },
    hide: function(a, b) {
        var c;
        if (a && !b && (c = a.srcElement ? a.srcElement : a.target),
        b || c != vZoom.loadingAreaImage && null != c && c != document && c != vZoom.magnifyingGlass && c != vZoom.activeProperties.image && c != vZoom.magnifyingGlassImage && c != vZoom.transparentOverlay) {
            if (!vZoom.dontHide || c != vZoom.images[vZoom.filter(vZoom.activeProperties.image.src)])
                return vZoom.dontHide = !1,
                DetachEvent(document, "mousemove", vZoom.onmousemove),
                vZoom.magnifyingGlass.style.display = "none",
                vZoom.zoomArea.style.display = "none",
                vZoom.transparentOverlay.style.display = "none",
                vZoom.loadingArea.style.display = "none",
                vZoom.iframe.style.display = "none",
                vZoom.mouse.left = 0,
                vZoom.mouse.top = 0,
                vZoom.activeProperties = {
                    image: null,
                    zoomImage: null,
                    imagePlacement: null,
                    scaleX: 0,
                    scaleY: 0,
                    magnifyingGlassBorderWidth: 0
                },
                !0;
            vZoom.dontHide = !1
        }
        return !1
    },
    onmousemove: function(a) {
        var a = window.event || a;
        if (!vZoom.hide(a)) {
            if (a.clientX) {
                var b = document.documentElement.scrollLeft || document.body.scrollLeft
                  , c = document.documentElement.scrollTop || document.body.scrollTop;
                b += a.clientX,
                c += a.clientY
            } else
                var b = vZoom.mouse.left
                  , c = vZoom.mouse.top;
            vZoom.mouse.left = b,
            vZoom.mouse.top = c;
            var d = vZoom.filter(vZoom.activeProperties.image.src);
            if (1 == vZoom.images[d].loaded) {
                var e = vZoom.magnifyingGlass
                  , f = {
                    width: e.offsetWidth,
                    height: e.offsetHeight
                }
                  , g = vZoom.activeProperties.imagePlacement;
                b -= f.width / 2,
                c -= f.height / 2,
                b < g.left + vZoom.activeProperties.imageBorderWidth ? b = g.left + vZoom.activeProperties.imageBorderWidth : b > g.left + g.width - f.width - vZoom.activeProperties.imageBorderWidth && (b = g.left + g.width - f.width - vZoom.activeProperties.imageBorderWidth),
                c < g.top + vZoom.activeProperties.imageBorderWidth ? c = g.top + vZoom.activeProperties.imageBorderWidth : c > g.top + g.height - f.height - vZoom.activeProperties.imageBorderWidth && (c = g.top + g.height - f.height - vZoom.activeProperties.imageBorderWidth),
                e.style.left = b + "px",
                e.style.top = c + "px",
                b -= g.left,
                c -= g.top,
                b < 0 && (b = 0),
                c < 0 && (c = 0),
                b += vZoom.activeProperties.magnifyingGlassBorderWidth,
                c += vZoom.activeProperties.magnifyingGlassBorderWidth;
                var h = vZoom.activeProperties.scaleX
                  , i = vZoom.activeProperties.scaleY;
                vZoom.displayImage.style.left = -b * h + "px",
                vZoom.displayImage.style.top = -c * i + "px",
                vZoom.magnifyingGlassImage.style.left = parseFloat(g.left) - parseFloat(vZoom.magnifyingGlass.style.left) - vZoom.activeProperties.magnifyingGlassBorderWidth + vZoom.activeProperties.imageBorderWidth + "px",
                vZoom.magnifyingGlassImage.style.top = parseFloat(g.top) - parseFloat(vZoom.magnifyingGlass.style.top) - vZoom.activeProperties.magnifyingGlassBorderWidth + vZoom.activeProperties.imageBorderWidth + "px"
            }
        }
    }
};
