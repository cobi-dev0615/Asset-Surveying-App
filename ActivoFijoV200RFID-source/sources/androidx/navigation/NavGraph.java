package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* compiled from: NavGraph.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001LB\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u001f\u0010\"\u001a\u00020\u001e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010#\"\u00020\u0001¢\u0006\u0002\u0010$J\u0016\u0010\"\u001a\u00020\u001e2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010%J\u0006\u0010&\u001a\u00020\u001eJ\u0013\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010)H\u0096\u0002J\u0013\u0010*\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010+\u0018\u0001H\u0086\bJ\u001d\u0010*\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010+2\b\u0010,\u001a\u0004\u0018\u0001H+¢\u0006\u0002\u0010-J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010.\u001a\u00020\u0011J\u001a\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u00072\u0006\u0010/\u001a\u00020(H\u0007J\u0012\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010\u0007J2\u00100\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010.\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020(2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0001H\u0007J\b\u00104\u001a\u00020\u0011H\u0007J\b\u00105\u001a\u00020\u0011H\u0016J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000107H\u0086\u0002J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0017J*\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u00102\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u00101\u001a\u00020\u0001H\u0007J*\u0010>\u001a\u0004\u0018\u0001092\u0006\u0010,\u001a\u00020\u00072\u0006\u00102\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u00101\u001a\u00020\u0001H\u0007J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u000e\u0010D\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0001J\u0015\u0010E\u001a\u00020\u001e\"\n\b\u0000\u0010+\u0018\u0001*\u00020)H\u0086\bJ\u001d\u0010E\u001a\u00020\u001e\"\b\b\u0000\u0010+*\u00020)2\u0006\u0010\u0018\u001a\u0002H+¢\u0006\u0002\u0010FJ\u000e\u0010E\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010E\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0007J0\u0010E\u001a\u00020\u001e\"\u0004\b\u0000\u0010+2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002H+0H2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070JH\u0007J\b\u0010K\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118G@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u001c¨\u0006M"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "navGraphNavigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "nodes", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "startDestDisplayName", "getStartDestDisplayName", "startDestId", "", "startDestIdName", "startDestinationId", "getStartDestinationId", "()I", "setStartDestinationId", "(I)V", "startDestRoute", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "(Ljava/lang/String;)V", "addAll", "", "other", "addDestination", "node", "addDestinations", "", "([Landroidx/navigation/NavDestination;)V", "", "clear", "equals", "", "", "findNode", ExifInterface.GPS_DIRECTION_TRUE, "route", "(Ljava/lang/Object;)Landroidx/navigation/NavDestination;", "resId", "searchParents", "findNodeComprehensive", "lastVisited", "searchChildren", "matchingDest", "getStartDestination", "hashCode", "iterator", "", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "matchDeepLinkComprehensive", "searchParent", "matchRouteComprehensive", "onInflate", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "remove", "setStartDestination", "(Ljava/lang/Object;)V", "serializer", "Lkotlinx/serialization/KSerializer;", "parseRoute", "Lkotlin/Function1;", "toString", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @JvmStatic
    public static final NavDestination findStartDestination(NavGraph navGraph) {
        return INSTANCE.findStartDestination(navGraph);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.checkNotNullParameter(navGraphNavigator, "navGraphNavigator");
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        super.onInflate(context, attrs);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.NavGraphNavigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…leable.NavGraphNavigator)");
        setStartDestinationId(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.startDestIdName = NavDestination.INSTANCE.getDisplayName(context, this.startDestId);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String route, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        NavDestination.DeepLinkMatch matchRoute;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchRoute2 = matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                if (Intrinsics.areEqual(navDestination, lastVisited)) {
                    matchRoute = null;
                } else if (navDestination instanceof NavGraph) {
                    matchRoute = ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this);
                } else {
                    matchRoute = navDestination.matchRoute(route);
                }
                if (matchRoute != null) {
                    arrayList.add(matchRoute);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchRouteComprehensive(route, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{matchRoute2, deepLinkMatch, deepLinkMatch2}));
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(NavDeepLinkRequest navDeepLinkRequest, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                NavDestination.DeepLinkMatch matchDeepLink2 = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.matchDeepLink(navDeepLinkRequest) : null;
                if (matchDeepLink2 != null) {
                    arrayList.add(matchDeepLink2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchDeepLinkComprehensive(navDeepLinkRequest, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{matchDeepLink, deepLinkMatch, deepLinkMatch2}));
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive(navDeepLinkRequest, true, false, this);
    }

    public final void addDestination(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (getRoute() != null && Intrinsics.areEqual(route, getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (id == getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations(Collection<? extends NavDestination> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void addDestinations(NavDestination... nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            addDestination(navDestination);
        }
    }

    public final NavDestination findNode(int resId) {
        return findNodeComprehensive$default(this, resId, this, false, null, 8, null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$default(NavGraph navGraph, int i, NavDestination navDestination, boolean z, NavDestination navDestination2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNodeComprehensive");
        }
        if ((i2 & 8) != 0) {
            navDestination2 = null;
        }
        return navGraph.findNodeComprehensive(i, navDestination, z, navDestination2);
    }

    public final NavDestination findNodeComprehensive(int resId, NavDestination lastVisited, boolean searchChildren, NavDestination matchingDest) {
        NavDestination navDestination = this.nodes.get(resId);
        if (matchingDest != null) {
            if (Intrinsics.areEqual(navDestination, matchingDest) && Intrinsics.areEqual(navDestination.getParent(), matchingDest.getParent())) {
                return navDestination;
            }
            navDestination = null;
        } else if (navDestination != null) {
            return navDestination;
        }
        if (searchChildren) {
            Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    navDestination = null;
                    break;
                }
                NavDestination navDestination2 = (NavDestination) it.next();
                NavDestination findNodeComprehensive = (!(navDestination2 instanceof NavGraph) || Intrinsics.areEqual(navDestination2, lastVisited)) ? null : ((NavGraph) navDestination2).findNodeComprehensive(resId, this, true, matchingDest);
                if (findNodeComprehensive != null) {
                    navDestination = findNodeComprehensive;
                    break;
                }
            }
        }
        if (navDestination != null) {
            return navDestination;
        }
        if (getParent() == null || Intrinsics.areEqual(getParent(), lastVisited)) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNodeComprehensive(resId, this, searchChildren, matchingDest);
    }

    public final NavDestination findNode(String route) {
        String str = route;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return findNode(route, true);
    }

    public final /* synthetic */ <T> NavDestination findNode() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        return findNode(RouteSerializerKt.generateHashCode(SerializersKt.serializer((KType) null)));
    }

    public final <T> NavDestination findNode(T route) {
        if (route != null) {
            return findNode(RouteSerializerKt.generateHashCode(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()))));
        }
        return null;
    }

    public final NavDestination findNode(String route, boolean searchParents) {
        Object obj;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            NavDestination navDestination = (NavDestination) obj;
            if (StringsKt.equals$default(navDestination.getRoute(), route, false, 2, null) || navDestination.matchRoute(route) != null) {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) obj;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!searchParents || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(route);
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    public final void addAll(NavGraph other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator<NavDestination> it = other.iterator();
        while (it.hasNext()) {
            NavDestination next = it.next();
            it.remove();
            addDestination(next);
        }
    }

    public final void remove(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int indexOfKey = this.nodes.indexOfKey(node.getId());
        if (indexOfKey >= 0) {
            this.nodes.valueAt(indexOfKey).setParent(null);
            this.nodes.removeAt(indexOfKey);
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    @Deprecated(message = "Use getStartDestinationId instead.", replaceWith = @ReplaceWith(expression = "startDestinationId", imports = {}))
    public final int getStartDestination() {
        return getStartDestId();
    }

    /* renamed from: getStartDestinationId, reason: from getter */
    public final int getStartDestId() {
        return this.startDestId;
    }

    private final void setStartDestinationId(int i) {
        if (i == getId()) {
            throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
        }
        if (this.startDestinationRoute != null) {
            setStartDestinationRoute(null);
        }
        this.startDestId = i;
        this.startDestIdName = null;
    }

    public final void setStartDestination(int startDestId) {
        setStartDestinationId(startDestId);
    }

    public final void setStartDestination(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestinationRoute(startDestRoute);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> void setStartDestination() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        setStartDestination(SerializersKt.serializer((KType) null), new Function1<NavDestination, String>() { // from class: androidx.navigation.NavGraph$setStartDestination$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(NavDestination startDestination) {
                Intrinsics.checkNotNullParameter(startDestination, "startDestination");
                String route = startDestination.getRoute();
                Intrinsics.checkNotNull(route);
                return route;
            }
        });
    }

    public final <T> void setStartDestination(final T startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(startDestRoute.getClass())), new Function1<NavDestination, String>() { // from class: androidx.navigation.NavGraph$setStartDestination$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(NavDestination startDestination) {
                Intrinsics.checkNotNullParameter(startDestination, "startDestination");
                Map<String, NavArgument> arguments = startDestination.getArguments();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
                Iterator<T> it = arguments.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
                }
                return RouteSerializerKt.generateRouteWithArgs(startDestRoute, linkedHashMap);
            }
        });
    }

    public final <T> void setStartDestination(KSerializer<T> serializer, Function1<? super NavDestination, String> parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int generateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination findNode = findNode(generateHashCode);
        if (findNode == null) {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
        setStartDestinationRoute(parseRoute.invoke(findNode));
        this.startDestId = generateHashCode;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    private final void setStartDestinationRoute(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else {
            if (Intrinsics.areEqual(str, getRoute())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
            }
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
            }
            hashCode = NavDestination.INSTANCE.createRoute(str).hashCode();
        }
        this.startDestId = hashCode;
        this.startDestinationRoute = str;
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination findNode = findNode(this.startDestinationRoute);
        if (findNode == null) {
            findNode = findNode(getStartDestId());
        }
        sb.append(" startDestination=");
        if (findNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavGraph)) {
            return false;
        }
        if (super.equals(other)) {
            NavGraph navGraph = (NavGraph) other;
            if (this.nodes.size() == navGraph.nodes.size() && getStartDestId() == navGraph.getStartDestId()) {
                for (NavDestination navDestination : SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes))) {
                    if (!Intrinsics.areEqual(navDestination, navGraph.nodes.get(navDestination.getId()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int startDestId = getStartDestId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            startDestId = (((startDestId * 31) + sparseArrayCompat.keyAt(i)) * 31) + sparseArrayCompat.valueAt(i).hashCode();
        }
        return startDestId;
    }

    /* compiled from: NavGraph.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0007J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "()V", "childHierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "findStartDestination", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NavDestination findStartDestination(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.last(childHierarchy(navGraph));
        }

        public final Sequence<NavDestination> childHierarchy(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return SequencesKt.generateSequence(navGraph, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$childHierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.findNode(navGraph2.getStartDestId());
                }
            });
        }
    }
}
